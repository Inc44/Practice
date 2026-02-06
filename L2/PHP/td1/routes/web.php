<?php

use App\Http\Controllers\UserController;
use App\Http\Controllers\VideoController;
use App\Http\Controllers\BookController;
use App\Http\Controllers\AuthorController;
use Illuminate\Support\Facades\Route;

Route::get("/", function () {
	return view("welcome");
})->name("home");

Route::middleware(["auth"])->group(function () {
	Route::get("/dashboard", function () {
		return view("dashboard", ["title" => "Dashboard"]);
	})->name("dashboard");

	Route::resource("users", UserController::class);
	Route::resource("videos", VideoController::class)->only(["index"]);
	Route::resource("books", BookController::class)->only(["index", "show"]);
	Route::resource("authors", AuthorController::class)->only(["show"]);
});

require __DIR__ . "/auth.php";
