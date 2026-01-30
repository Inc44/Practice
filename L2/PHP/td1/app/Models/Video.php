<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Video extends Model
{
    /** @use HasFactory<\Database\Factories\VideoFactory> */
    use HasFactory;

	/**
	 * The attributes that are mass assignable.
	 *
	 * @var list<string>
	 */
    protected $fillable = [
        'title',
        'description',
        'image',
        'year',
        'price',
        'is_published',
    ];
}
