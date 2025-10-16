'use strict';
const e = React.createElement;
const API_KEY = '1fbce9937aadd6f812f0c9a2e153f4ad';
const API_URL_POPULAR = 'https://api.themoviedb.org/3/movie/popular';
const API_URL_SEARCH = 'https://api.themoviedb.org/3/search/movie';
const IMG_URL_PREFIX = 'https://image.tmdb.org/t/p/w200';
class MovieApp extends React.Component
{
	constructor(props)
	{
		super(props);
		this.state = {
			movies: [],
			searchQuery: '',
			loading: true,
			error: null
		};
		this.handleSearchChange = this.handleSearchChange.bind(this);
		this.handleSearchSubmit = this.handleSearchSubmit.bind(this);
	}
	componentDidMount()
	{
		this.fetchMovies(API_URL_POPULAR);
	}
	fetchMovies(baseUrl, query = '')
	{
		this.setState(
		{
			loading: true,
			error: null
		});
		let url = `${baseUrl}?api_key=${API_KEY}`;
		if (query)
		{
			url += `&query=${encodeURIComponent(query)}`;
		}
		fetch(url)
			.then(response =>
			{
				if (!response.ok)
				{
					throw new Error('Network response was not ok');
				}
				return response.json();
			})
			.then(data =>
			{
				this.setState(
				{
					movies: data.results,
					loading: false
				});
			})
			.catch(error =>
			{
				this.setState(
				{
					error: error.message,
					loading: false
				});
			});
	}
	handleSearchChange(event)
	{
		this.setState(
		{
			searchQuery: event.target.value
		});
	}
	handleSearchSubmit(event)
	{
		event.preventDefault();
		const
		{
			searchQuery
		} = this.state;
		if (searchQuery.trim())
		{
			this.fetchMovies(API_URL_SEARCH, searchQuery);
		}
		else
		{
			this.fetchMovies(API_URL_POPULAR);
		}
	}
	render()
	{
		const
		{
			movies,
			searchQuery,
			loading,
			error
		} = this.state;
		const searchBar = e('form',
			{
				key: 'search-bar',
				onSubmit: this.handleSearchSubmit
			},
			[
				e('input',
				{
					key: 'search-input',
					type: 'text',
					value: searchQuery,
					onChange: this.handleSearchChange,
					placeholder: 'Search for a movie...'
				}),
				e('button',
				{
					key: 'search-button',
					type: 'submit'
				}, 'Search')
			]);
		let content;
		if (loading)
		{
			content = e('p',
			{
				key: 'loading-movies'
			}, 'Loading movies...');
		}
		else if (error)
		{
			content = e('p',
			{
				key: 'error-message'
			}, `Error: ${error}`);
		}
		else if (movies.length === 0)
		{
			content = e('p',
			{
				key: 'no-movies-found'
			}, 'No movies found.');
		}
		else
		{
			content = e('div',
			{
				key: 'movies-container',
			}, movies.map(movie => e('div',
				{
					key: movie.id
				},
				[
					e('img',
					{
						key: 'img-' + movie.id,
						src: movie.poster_path ? `${IMG_URL_PREFIX}${movie.poster_path}` : 'https://lipsum.app/200x200/',
						alt: movie.title
					}),
					e('h4',
					{
						key: 'title-' + movie.id
					}, movie.title)
				])));
		}
		return e('div',
		{
			key: 'main-container'
		}, [
			e('h2',
			{
				key: 'main-title'
			}, 'Movie Database'),
			searchBar,
			content
		]);
	}
}
const domContainer = document.querySelector('#like_button_container');
const root = ReactDOM.createRoot(domContainer);
root.render(e(MovieApp));