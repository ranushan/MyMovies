/*window.addEventListener('load',function(){
	var page = 1;
	document.querySelector('button#next').addEventListener('click',function(){
		const req = new XMLHttpRequest();
		req.open('GET', "/data?page="+page); 
		req.send();
		req.onreadystatechange = function(event){
			if(	req.readyState ==4){
				if (req.status === 200) {
				 JSON.parse(req.response).results.map(
			        		(element,i)=>{
			        			$('#root').append($(`<div class="col s12 m6 l4">
												      <div class="card">
												        <div class="card-image">
												          <img src="https://image.tmdb.org/t/p/w500`+element.poster_path+`">
												          <span class="card-title">`+element.title+`</span>
												        </div>
												        <div class="card-content">`+element.overview+`.</p>
												        </div>
												        <div class="card-action">
												          <a idpage="`+element.id+`" class="liensDetail">This is a link</a>
												        </div>
												      </div>
												    </div>`));
			        		}		
			        		);
				} else {
				    console.log("Status de la réponse: %d (%s)", req.status, req.statusText);
				}			}
		}

	});

});
*/
$(document).ready(()=>{
var page = 0;
	$('button#next').click(()=>{
		page++;
		$.ajax("/data?page="+page).done(
				
				(d)=>{
					$('#root').html("");
			        		d.results.map(
			        		(element,i)=>{
			        			$('#root').append($(`<div class="col s6">
												      <div class="card">
												        <div class="card-image">
												          <img src="https://image.tmdb.org/t/p/w500`+element.poster_path+`">
												          <span class="card-title">`+element.title+`</span>
												        </div>
												        <div class="card-content">`+element.overview+`.</p>
												        </div>
												        <div class="card-action">
												          <a idpage="`+element.id+`" class="liensDetail">This is a link</a>
												        </div>
												      </div>
												    </div>`));
			        		}		
			        		);
			        		$('.liensDetail').click(function(){
			        			console.log(this)
			        			let idpage = $(this).attr('idpage');
			        			$.ajax("/details?pageid="+idpage).done(()=>{
			        				console.log(d)
			        			})

			        		})
			        		
			        		
				}
			);
	})
	$('button#load').click(()=>{
		$.ajax("/data").done(
				(d)=>{
			        		d.results.map(
			        		(element,i)=>{
			        			$('#root').append($(`<div class="row">
												    <div class="col s12 m7">
												      <div class="card">
												        <div class="card-image">
												          <img src="https://image.tmdb.org/t/p/w500`+element.poster_path+`">
												          <span class="card-title">Card Title</span>
												        </div>
												        <div class="card-content">
												          <p>I am a very simple card. I am good at containing small bits of information.
												          I am convenient because I require little markup to use effectively.</p>
												        </div>
												        <div class="card-action">
												          <a href="#">This is a link</a>
												        </div>
												      </div>
												    </div>
												  </div>`));
			        		}		
			        		);
				}
			);
	});
	

		
	
	
	
	
});