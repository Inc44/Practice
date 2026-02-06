<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

class Book extends Model
{
	/** @use HasFactory<\Database\Factories\BookFactory> */
	use HasFactory;

	protected $fillable = [
		"title",
		"description",
		"image",
		"page",
		"price",
		"is_published",
		"author_id",
	];

	public function author(): BelongsTo
	{
		return $this->belongsTo(Author::class);
	}
}
