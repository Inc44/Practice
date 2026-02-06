<?php

namespace Database\Seeders;

use App\Models\Author;
use App\Models\Book;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class BookSeeder extends Seeder
{
	/**
	 * Run the database seeds.
	 */
	public function run(): void
	{
		if (Author::count() == 0) {
			$this->call(AuthorSeeder::class);
		}

		$authors = Author::all();

		Book::factory(25)
			->make()
			->each(function ($book) use ($authors) {
				$book->author_id = $authors->random()->id;
				$book->save();
			});
	}
}
