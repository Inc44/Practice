<?php

namespace App\Http\Controllers;

use App\Models\Author;
use Illuminate\Http\Request;

class AuthorController extends Controller
{
	/**
	 * Show the form for editing the specified resource.
	 */
	public function show(Author $author)
	{
		$author->load("books");
		return view("authors.show", compact("author"));
	}
}
