@extends('layouts.app')

@section('content')
    <div class="space-y-6">
        @session('success')
            <x-ui.alert variant="success">
                {{ $value }}
            </x-ui.alert>
        @endsession

        <div class="rounded-box shadow-base-300/10 bg-base-100 w-full pb-2 shadow-md">
            <div class="overflow-x-auto">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Image</th>
                            <th>Pages</th>
                            <th>Price</th>
                            <th>Status</th>
                            <th>Author</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        @forelse ($books as $book)
                            <tr>
                                <td>{{ $book->title }}</td>
                                <td>{{ $book->image ?? '-' }}</td>
                                <td>{{ $book->page }}</td>
                                <td>${{ $book->price }}</td>
                                <td>
                                    @if($book->is_published)
                                        <span class="badge badge-soft badge-success">Published</span>
                                    @else
                                        <span class="badge badge-soft badge-warning">Draft</span>
                                    @endif
                                </td>
                                <td>{{ $book->author->full_name }}</td>
                                <td>
                                    <a href="{{ route('books.show', $book) }}" class="btn btn-circle btn-text btn-sm" aria-label="View book">
                                        <span class="icon-[tabler--eye] size-5"></span>
                                    </a>
                                </td>
                            </tr>
                        @empty
                            <tr>
                                <td colspan="7" class="text-center py-8">
                                    <p class="text-base-content/70">No books found.</p>
                                </td>
                            </tr>
                        @endforelse
                    </tbody>
                </table>
            </div>
        </div>

        @if ($books->hasPages())
            <div class="mt-4">
                {{ $books->links() }}
            </div>
        @endif
    </div>
@endsection