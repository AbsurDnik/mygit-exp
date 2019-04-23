<#import "/parts/custom.ftl" as c>
<@c.page>
<h2>List of all booking in this hotel</h2>
<div class="card-columns">
	<#list booklist as book>
		<div class="card my-3" style="width: 18rem;">
			<div class = "m-2">
				<span>${book.category}</span></br>
				<span>${book.price}$</span></br>
				<i>№${book.number}</i>
			</div>
		</div>
	</#list>
</div>
</@c.page>