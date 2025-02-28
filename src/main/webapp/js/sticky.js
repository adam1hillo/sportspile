window.onscroll = function() {onscroll()};
window.onload =  function (){onload()};

// Get the header
var header = document.getElementById("my-header");


// Add the sticky class to the header when you reach its scroll position. Remove "sticky" when you leave the scroll position
function onscroll() {
    if ( window.pageYOffset > 40 ) {
        header.classList.add( "sticky" );
    } else {
        setTimeout(function(){
            header.classList.remove( "sticky" );
        }, 100);
    }
}


function onload() {
    if ( window.scrollY !== 0 ) {
        header.classList.add( "sticky" );
        console.log(header.classList)
    } else {
        setTimeout(function(){
            header.classList.remove( "sticky" );
        }, 100);
    }
}