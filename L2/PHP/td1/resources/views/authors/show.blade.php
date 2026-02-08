@extends('layouts.app') @section('content') <div class="space-y-6">
	<div class="bg-base-100 shadow-base-300/20 w-full space-y-6 rounded-xl p-6 shadow-md lg:p-8">
		<div class="flex items-center justify-between">
			<div>
				<h3 class="text-base-content mb-1.5 text-2xl font-semibold">{{ $author->full_name }}</h3>
			</div>
			<a href="{{ route('books.index') }}" class="btn btn-outline">Back to Books</a>
		</div>
		<div class="space-y-4">
			<div>
				<h4 class="text-base-content font-semibold mb-1">Biography</h4>
				<p class="text-base-content/80">{{ $author->biography ?? 'No biography available' }}</p>
			</div>
			<div class="border-t border-base-content/20 pt-6"> @if($author->books->count() > 0) <div class="grid grid-cols-1 gap-4 sm:grid-cols-2 lg:grid-cols-3"> @foreach($author->books as $book) <a href="{{ route('books.show', $book) }}" class="card bg-base-200 hover:bg-base-300 transition-colors">
						<div class="card-body p-4">
							<h5 class="card-title text-base-content">{{ $book->title }}</h5>
							<p class="text-base-content/60 text-sm line-clamp-2">{{ $book->description ?? 'No description' }}</p>
							<div class="flex items-center justify-between mt-2">
								<span class="text-base-content/80 text-sm">${{ $book->price }}</span> @if($book->is_published) <span class="badge badge-soft badge-success text-xs">Published</span> @else <span class="badge badge-soft badge-warning text-xs">Draft</span> @endif
							</div>
						</div>
					</a> @endforeach </div> @else <p class="text-base-content/60">No books found for this author.</p> @endif </div>
		</div>
	</div>
</div> @endsection