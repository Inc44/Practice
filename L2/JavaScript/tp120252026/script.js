(function()
{
	var width = window.innerWidth / 16;
	var list = [70, 62, 33, 16];
	if (width <= 90) list = [44, 38, 20, 10];
	if (width <= 30) list = [95, 84, 45, 22];
	var purecounters = document.querySelectorAll(".purecounter");
	for (var i = 0; i < purecounters.length; i++)
	{
		purecounters[i].setAttribute("data-purecounter-end", list[i]);
	}
	new PureCounter();
})();