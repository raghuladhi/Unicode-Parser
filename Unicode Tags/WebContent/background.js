/**
 * 
 */

function render(){
	var inputText = document.getElementById("inputText");
	var outputText = document.getElementById("outputText");
	fetch('http://localhost:8081/Unicode_Tags/render',{
		method:'POST',
		body:inputText.value,
		header:{
			'content-type':'text/plain'
		}
	})
	.then(function(response) {
		console.log("Successful request");
	    response.text()
	    	.then(function(text){
	    		outputText.value=text;
	    		console.log(text);
	    	});
	    
	})
	.catch(function(err){
		console.log("error is "+err);
	});
	
	
}