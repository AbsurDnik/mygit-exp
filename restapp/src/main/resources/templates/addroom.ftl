<#import "/parts/custom.ftl" as c>
<@c.page>






<div>
	<a class="btn btn-primary mb-2" data-toggle="collapse" 
		href = "#collapse"
		role="button" aria-expanded="false" aria-controls="collapseExample">
			Add Room in hotel
	</a>
</div>
<div class="collapse" id="collapse">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
        
        	<div class="form-group">
                <input type="text" class="form-control" name="number" 
                	   placeholder="Number">
            </div>
        	
            <div class="form-group">
                <input type="text" class="form-control" name="category" 
                	   placeholder="Category">
            </div>
            
            <div class="form-group">
                <input type="text" class="form-control" name="price" 
                	   placeholder="Price">
            </div>
            
    
            
			<div class="custom-control custom-checkbox mb-2">
			  <input type="checkbox" class="custom-control-input" id="customCheck1" name = "isBusy">
			  <label class="custom-control-label" for="customCheck1">Is Busy</label>
			</div>
			
			
            
            
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Add room</button>
            </div>
        </form>
    </div>
</div>

















</@c.page>