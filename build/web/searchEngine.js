
//Eleazar De Paz
//10/23

const SearchEngine = () => {
  
	//Variables from the HTML Tags
	let searchbar = document.getElementById("search-query").value.toUpperCase();//search bar value
	//let itemsList = document.getElementById("ItemsList")//new div list for a products list
	let product = document.querySelectorAll(".product")//gathers all products from the arcticle tags
	let pname = document.getElementsByTagName("h2")//text of the products
	

    for (var i = 0; i < pname.length; i++) {
        let match = product[i].getElementsByTagName("h2")[0];//getting product name from the the article tags 
       
		if (match){
			
			let textValue = match.textContent || match.innerHTML //text value to check if user text matches with our product text/prodcut name
			
				if (textValue.toUpperCase().indexOf(searchbar) > -1) {
					product[i].style.display = "";//displays items
					
				} else {
					product[i].style.display = "none";//hides with the none property if values do not match
				}
		}

    }
}

const searchBtn = document.querySelector("#searchBtn");
searchBtn.addEventListener("onclick", SearchEngine);


