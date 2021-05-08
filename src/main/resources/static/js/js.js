window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 100 || document.documentElement.scrollTop >100) {
       document.getElementById("fixed-nav").style.backgroundColor = "##ffffff91";
       document.getElementById("fixed-nav").style.position = "fixed";
       document.getElementById("fixed-nav").style.left = "0";
       document.getElementById("fixed-nav").style.right = "0";
       document.getElementById("fixed-nav").style.zIndex  = "3";
     //  document.getElementById("navbarCollapse > a").style.color = "#000000";
  } else {
       document.getElementById("fixed-nav").style.backgroundColor = "#ffffff91";

           document.getElementById("fixed-nav").style.left = "0";
           document.getElementById("fixed-nav").style.right = "0";
  }
}

