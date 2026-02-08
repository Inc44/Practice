@extends('layouts.app') @section('content') <div class="space-y-6">
	<div class="bg-base-100 shadow-base-300/20 w-full space-y-6 rounded-xl p-6 shadow-md lg:p-8">
		<div class="flex items-center justify-between">
			<div>
				<h3 class="text-base-content mb-1.5 text-2xl font-semibold">{{ $book->title }}</h3>
			</div>
			<a href="{{ route('books.index') }}" class="btn btn-outline">Back to List</a>
		</div>
		<div class="grid grid-cols-1 gap-6 md:grid-cols-2"> @if($book->image) <div>
				<img src="{{ $book->image }}" alt="{{ $book->title }}" class="rounded-lg w-full h-auto">
			</div> @endif <div class="space-y-4">
				<div>
					<h4 class="text-base-content font-semibold mb-1">Description</h4>
					<p class="text-base-content/80">{{ $book->description ?? 'No description available' }}</p>
				</div>
				<div class="grid grid-cols-4 gap-4">
					<div>
						<h4 class="text-base-content font-semibold mb-1">Pages</h4>
						<p class="text-base-content/80">{{ $book->page }}</p>
					</div>
					<div>
						<h4 class="text-base-content font-semibold mb-1">Price</h4>
						<p class="text-base-content/80">${{ $book->price }}</p>
					</div>
					<div>
						<h4 class="text-base-content font-semibold mb-1">Status</h4> @if($book->is_published) <span class="badge badge-soft badge-success">Published</span> @else <span class="badge badge-soft badge-warning">Draft</span> @endif
					</div>
					<div>
						<h4 class="text-base-content font-semibold mb-1">Author</h4>
						<a href="{{ route('authors.show', $book->author) }}" class="link link-animated">
							{{ $book->author->full_name }}
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div> @endsection