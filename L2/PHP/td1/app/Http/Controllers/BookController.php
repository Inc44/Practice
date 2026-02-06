<?php

namespace App\Http\Controllers;

use App\Models\Book;
use Illuminate\Http\Request;

class BookController extends Controller
{
	/**
	 * Display a listing of the resource.
	 */
	public function index()
	{
		$books = Book::with("author")->paginate(10);
		return view("books.index", compact("books"));
	}

	/**
	 * Show the form for editing the specified resource.
	 */
	public function show(Book $book)
	{
		$book->load("author");
		return view("books.show", compact("book"));
	}
}
