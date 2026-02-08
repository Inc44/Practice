<?php

namespace Database\Factories;

use App\Models\Author;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Book>
 */
class BookFactory extends Factory
{
	/**
	 * Define the model's default state.
	 *
	 * @return array<string, mixed>
	 */
	public function definition(): array
	{
		return [
			"title" => fake()->sentence(3),
			"description" => fake()->paragraph(),
			"image" =>
				"https://picsum.photos/seed/" .
				fake()
					->unique()
					->numberBetween(1, 100) .
				"/1200/1600",
			"page" => fake()->numberBetween(100, 1000),
			"price" => fake()->numberBetween(1, 100),
			"is_published" => fake()->boolean(90),
			"author_id" => Author::factory(),
		];
	}
}
