@extends('layouts.app') @section('content') <div class="space-y-6"> @session('success') <x-ui.alert variant="success">
		{{ $value }}
	</x-ui.alert> @endsession <div class="rounded-box shadow-base-300/10 bg-base-100 w-full pb-2 shadow-md">
		<div class="overflow-x-auto">
			<table class="table">
				<thead>
					<tr>
						<th>Title</th>
						<th>Image</th>
						<th>Year</th>
						<th>Price</th>
						<th>Created At</th>
						<th>Updated At</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody> @forelse ($videos as $video) <tr>
						<td>{{ $video->title }}</td>
						<td>{{ $video->image ?? '-' }}</td>
						<td>{{ $video->year }}</td>
						<td>{{ $video->price }}</td>
						<td>{{ $video->created_at->format('F j, Y') }}</td>
						<td>{{ $video->updated_at->format('F j, Y') }}</td>
						<td>
							<a class="btn btn-circle btn-text btn-sm" aria-label="Edit video">
								<span class="icon-[tabler--pencil] size-5"></span>
							</a>
						</td>
					</tr> @empty <tr>
						<td colspan="7" class="text-center py-8">
							<p class="text-base-content/70">No videos found.</p>
						</td>
					</tr> @endforelse </tbody>
			</table>
		</div>
	</div> @if ($videos->hasPages()) <div class="mt-4">
		{{ $videos->links() }}
	</div> @endif </div> @endsection