<?php

namespace Tests\Feature;

use App\Models\Author;
use App\Models\Book;
use App\Models\User;
use Illuminate\Foundation\Testing\RefreshDatabase;
// use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class BookTest extends TestCase
{
	use RefreshDatabase;

	public function test_user_could_access_to_books_page()
	{
		$this->actingAs($user = User::factory()->create());

		$author = Author::factory()->create();
		$books = Book::factory()
			->count(3)
			->create(["author_id" => $author->id]);

		$response = $this->get(route("books.index"));
		$response->assertStatus(200);
		$response->assertViewIs("books.index");
		$response->assertSee($books[0]->title);
	}

	public function test_user_could_access_to_books_page_two()
	{
		$this->actingAs($user = User::factory()->create());

		$author = Author::factory()->create();
		$books = Book::factory(16)->create(["author_id" => $author->id]);

		$response = $this->get(route("books.index") . "?page=2");
		$response->assertStatus(200);
		$response->assertViewIs("books.index");
		$response->assertSee($books[15]->title);
	}

	public function test_user_could_consult_a_book()
	{
		$this->actingAs($user = User::factory()->create());

		$author = Author::factory()->create();
		$book = Book::factory()->create(["author_id" => $author->id]);

		$response = $this->get(route("books.show", $book->id));

		$response->assertStatus(200);
		$response->assertViewIs("books.show");
		$response->assertSee($book->title);
		$response->assertSee(
			$book->author->firstname . " " . $book->author->name
		);
	}

	public function test_user_could_consult_an_author_of_a_book()
	{
		$this->actingAs($user = User::factory()->create());

		$author = Author::factory()->create();
		$books = Book::factory(3)->create(["author_id" => $author->id]);

		$response = $this->get(route("authors.show", $author->id));
		$response->assertStatus(200);
		$response->assertViewIs("authors.show");
		$response->assertSee($author->firstname . " " . $author->name);
		$response->assertSee($books[0]->title);
		$response->assertSee($books[1]->title);
		$response->assertSee($books[2]->title);
	}
}
