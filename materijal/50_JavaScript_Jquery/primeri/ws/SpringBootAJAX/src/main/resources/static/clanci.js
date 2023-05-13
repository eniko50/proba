function loadArticles () {
		$.get('api/articles',function (data, status) {
			var htmlArticles='';
			for (var i = 0; i < data.length; i++) {
				htmlArticles+='<div><h2>'+data[i].title+'</h2><h3>'+data[i].description+'</h3><p>'+data[i].text+'</p></div><button id="btn-d-'+i+'">izbrisi</button>';
			};
			$('#articles').html(htmlArticles).promise().done(function () {
				for (var i = 0; i < data.length; i++) {
					(function (title) {
						$('#btn-d-'+i).click(function () {
							$.ajax({
								method: 'DELETE',
								url: 'api/articles/'+title
							}).done(loadArticles);
						});
					}(data[i].title));
				};
			});				
		});
	}
	$(document).ready(function () {
		$('#add-articles').click(loadArticles);
		$('#save').click(function () {
			$.ajax({
				url:'api/articles',
				method: 'POST',
				data: JSON.stringify({
					'title':$('#title').val(),
					'description':$('#description').val(),
					'text':$('#text').val()
				}),
				contentType:"application/json; charset=utf-8",
				dataType:"json",
			});
		})
	});