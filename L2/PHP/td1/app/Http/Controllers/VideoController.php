<?php

namespace App\Http\Controllers;

use App\Models\Video;
use Illuminate\Http\Request;

class VideoController extends Controller
{
	/**
	 * Display a listing of the resource.
	 */
	public function index()
	{
		$videos = Video::paginate(10);

		return view("videos.index", compact("videos"));
	}
}
