<?php

use App\Http\Controllers\UserController;
use App\Http\Controllers\VideoController;
use Illuminate\Support\Facades\Route;

Route::get("/", function () {
	return view("welcome");
})->name("home");

Route::middleware(["auth"])->group(function () {
	Route::get("/dashboard", function () {
		return view("dashboard", ["title" => "Dashboard"]);
	})->name("dashboard");

	Route::resource("users", UserController::class);
    Route::resource("videos", VideoController::class)->only(['index']);
});

require __DIR__ . "/auth.php";
