<#import "/parts/custom.ftl" as c>
<@c.page>
<h2>Book room page</h2>
<h4 class="mb-3">Please choose date</h4> 
<form method="get" enctype="multipart/form-data">    	
            
            <div class="row">
			    <div class="col">
			      	<label>Дата заезда</label>
                	<input type="date" name="arrivalDate" value = "${arrivalDate?ifExists}">
			    </div>
			    <div class="col">
			      	<label>Дата отъезда</label>
               		<input type="date" name="departureDate" value = "${departureDate?ifExists}">
			    </div>
			</div>
			<div class="form-group mt-3">
                <button type="submit" class="btn btn-primary">Search available room</button>
            </div>
            
            <#if arrivalDate??>
            
            <h2>Result per date range ${arrivalDate} - ${departureDate}</h2>
            
            <div class="form-row">
				<div class="form-group col-md-6">
		            <input type="text" class="form-control" placeholder="Search By Category" name = "filter" value = "${filter?ifExists}">
		      		<button type="submit" class="btn btn-primary mt-2">Search</button>
      			</div>
			</div>
            </#if>
            
</form>


<div class="card-columns">
	<#list availableRooms?ifExists as room>
		<div class="card my-3" style="width: 18rem;">
			<div class = "m-2">
				<span>${room.category}</span></br>
				<span>${room.price}$</span></br>
				<i>№${room.number}</i>
			</div>
			<div class="card-footer container">
				<div class = "row">
					<form method="post" action="/booking-the-room/${room.id}" enctype="multipart/form-data">
						<input type="hidden" name="arrivalDate" value = "${arrivalDate?ifExists}">
               			<input type="hidden" name="departureDate" value = "${departureDate?ifExists}">
		    			<button type="submit" class = "col align-self-center">Book</button>
		    		</form>
		    	</div>
	  		</div>
		</div>
	</#list>
</div>
</@c.page>