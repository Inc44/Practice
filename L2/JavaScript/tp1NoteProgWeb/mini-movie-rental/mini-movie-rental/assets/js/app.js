const API_KEY = '1fbce9937aadd6f812f0c9a2e153f4ad';
const API_BASE_URL = 'https://api.themoviedb.org/3';
const IMAGE_BASE_URL = 'https://image.tmdb.org/t/p/w300';
let movies = [];
let rentedMovies = JSON.parse(localStorage.getItem('rentedMovies')) || [];
let currentPage = 1;
let totalResults = 0;
let totalApiPages = 1;
let itemsPerPage = 20;
let lastOpenButton = null;
const movieListEl = document.getElementById('movieList');
const totalResultsEl = document.getElementById('totalResults');
const loadMoreBtn = document.getElementById('loadMoreBtn');
const loader = document.getElementById('loader');
const searchTextEl = document.getElementById('searchText');
const filterLangEl = document.getElementById('filterLang');
const filterVoteEl = document.getElementById('filterVote');
const filterDateEl = document.getElementById('filterDate');
const filterFormEl = document.getElementById('filterForm');
const movieDetailModal = new bootstrap.Modal(document.getElementById('movieDetailModal'));
const confirmRentModal = new bootstrap.Modal(document.getElementById('confirmRentModal'));
const watchModal = new bootstrap.Modal(document.getElementById('watchModal'));
let lastWatchBtn = null;
const movieDetailTitle = document.getElementById('movieDetailTitle');
const movieDetailBody = document.getElementById('movieDetailBody');
const rentBtn = document.getElementById('rentBtn');
const watchTitle = document.getElementById('watchTitle');
const videoPlayer = document.getElementById('videoPlayer');
let selectedMovie = null;
// 7
// J'ai filtré avec JavaScript, car on ne peut pas filtrer avec la recherche de TMDB directement
// https://developer.themoviedb.org/reference/discover-movie
// https://developer.themoviedb.org/reference/search-movie
function applyFilters(movies)
{
	const lang = filterLangEl.value;
	const vote = filterVoteEl.value;
	const date = filterDateEl.value;
	if (lang)
	{
		movies = movies.filter(movie => movie.original_language === lang);
	}
	if (vote)
	{
		movies = movies.filter(movie => movie.vote_average >= vote);
	}
	if (date)
	{
		movies = movies.filter(movie => movie.release_date >= date);
	}
	return movies;
}
async function fetchMovies(page = 1)
{
	const searchText = searchTextEl.value.trim();
	const lang = filterLangEl.value;
	const vote = filterVoteEl.value;
	const date = filterDateEl.value;
	let url = '';
	if (searchText.length > 0)
	{
		url = `${API_BASE_URL}/search/movie?api_key=${API_KEY}&language=fr-FR&query=${encodeURIComponent(searchText)}&page=${page}`;
	}
	else
	{
		url = `${API_BASE_URL}/discover/movie?api_key=${API_KEY}&language=fr-FR&page=${page}`;
		if (lang) url += `&with_original_language=${lang}`;
		if (vote) url += `&vote_average.gte=${vote}`;
		if (date) url += `&primary_release_date.gte=${date}`;
	}
	try
	{
		const res = await fetch(url);
		const data = await res.json();
		totalResults = data.total_results;
		totalApiPages = data.total_pages;
		// Si page 1 on remplace, sinon on concatène
		if (page === 1)
		{
			movies = data.results;
		}
		else
		{
			movies = movies.concat(data.results);
		}
		// 7
		movies = applyFilters(movies);
		currentPage = page;
		renderMovies();
		updateTotalResults();
	}
	catch (error)
	{
		console.error('Erreur API filtrage:', error);
	}
}

function renderMovies()
{
	movieListEl.innerHTML = '';
	const pagedMovies = movies.slice(0, currentPage * itemsPerPage);
	pagedMovies.forEach(movie =>
	{
		const rented = rentedMovies.includes(movie.id);
		const card = createMovieCard(movie, rented);
		movieListEl.appendChild(card);
	});
	// 1
	// console.log(pagedMovies.data[0]);
	console.log(pagedMovies[0]);
}

function createMovieCard(movie, rented)
{
	const col = document.createElement('div');
	col.className = 'col-6 col-md-4 col-lg-3';
	const card = document.createElement('div');
	card.className = 'card movie-card h-100';
	card.setAttribute('tabindex', '0');
	const img = document.createElement('img');
	// 4
	if (movie.poster_path)
	{
		img.src = IMAGE_BASE_URL + movie.poster_path;
	}
	else
	{
		img.src = '../../Ressources graphiques/Placeholder pour les vignettes.png';
	}
	img.alt = `Affiche du film ${movie.title}`;
	img.className = 'card-img-top movie-poster';
	const body = document.createElement('div');
	body.className = 'card-body d-flex flex-column';
	const title = document.createElement('h3');
	title.className = 'card-title h5';
	title.textContent = movie.title;
	const rentWatchBtn = document.createElement('button');
	rentWatchBtn.className = rented ? 'btn btn-primary watch-btn mt-auto' : 'btn btn-success rent-btn mt-auto';
	rentWatchBtn.textContent = rented ? 'Regarder' : 'Louer';
	rentWatchBtn.setAttribute('aria-label', rented ? `Regarder ${movie.title}` : `Louer ${movie.title}`);
	rentWatchBtn.addEventListener('click', (e) =>
	{
		e.stopPropagation();
		selectedMovie = movie;
		if (rented)
		{
			openWatchModal(movie);
		}
		else
		{
			openRentConfirmModal(movie);
		}
	});
	card.addEventListener('click', () =>
	{
		openMovieDetailModal(movie);
	});
	body.appendChild(title);
	body.appendChild(rentWatchBtn);
	card.appendChild(img);
	card.appendChild(body);
	col.appendChild(card);
	return col;
}

function openMovieDetailModal(movie)
{
	selectedMovie = movie;
	movieDetailTitle.textContent = movie.title;
	movieDetailBody.textContent = movie.overview || 'Pas de description disponible.';
	rentBtn.textContent = rentedMovies.includes(movie.id) ? 'Regarder' : 'Louer';
	rentBtn.setAttribute('aria-label', rentBtn.textContent + ' ' + movie.title);
	rentBtn.onclick = () =>
	{
		if (rentedMovies.includes(movie.id))
		{
			openWatchModal(movie);
		}
		else
		{
			openRentConfirmModal(movie);
		}
	};
	movieDetailModal.show();
}

function openRentConfirmModal(movie)
{
	movieDetailModal.hide();
	confirmRentModal.show();
	confirmRentModal._element.querySelector('button.btn-primary')
		.onclick = () =>
		{
			rentMovie(movie);
			confirmRentModal.hide();
			movieDetailModal.show();
		};
}

function rentMovie(movie)
{
	if (!rentedMovies.includes(movie.id))
	{
		rentedMovies.push(movie.id);
		localStorage.setItem('rentedMovies', JSON.stringify(rentedMovies));
		renderMovies();
	}
}

function openWatchModal(movie, btn)
{
	selectedMovie = movie;
	watchTitle.textContent = movie.title;
	videoPlayer.currentTime = 0;
	videoPlayer.play();
	watchModal.show();
	lastWatchBtn = btn;
}

function updateTotalResults()
{
	totalResultsEl.textContent = `${totalResults} films trouvés`;
	loadMoreBtn.disabled = currentPage >= totalApiPages;
}

function clearList()
{
	movieListEl.innerHTML = '';
}
filterFormEl.addEventListener('submit', async (e) =>
{
	e.preventDefault(); // Empêche le rechargement de page
	currentPage = 1;
	movies = [];
	await fetchMovies(currentPage);
});
loadMoreBtn.addEventListener('click', async () =>
{
	// Affiche loader, masque bouton
	loadMoreBtn.style.display = 'none';
	loader.style.display = 'inline-block';
	if (currentPage < totalApiPages)
	{
		await fetchMovies(currentPage + 1);
	}
	// Cache loader, réaffiche bouton si pages restantes
	loader.style.display = 'none';
	if (currentPage < totalApiPages)
	{
		loadMoreBtn.style.display = 'inline-block';
	}
});
document.addEventListener('DOMContentLoaded', async () =>
{
	// Code qui attend que le DOM soit prêt
	document.getElementById('watchModal')
		.addEventListener('hidden.bs.modal', () =>
		{
			// Fermeture de la modal de lecture
			const videoPlayer = document.getElementById('videoPlayer');
			videoPlayer.pause();
			videoPlayer.currentTime = 0;
			if (lastWatchBtn)
			{
				lastWatchBtn.focus();
				lastWatchBtn = null
			}
		});
	// Initial fetch
	await fetchMovies();
	// 5
	const filterToggleBtn = document.getElementById('filterToggleBtn');
	const filters = document.getElementById('filters');
	if (filterToggleBtn && filters)
	{
		filterToggleBtn.onclick = () =>
		{
			filters.classList.toggle('hide');
		};
	}
});