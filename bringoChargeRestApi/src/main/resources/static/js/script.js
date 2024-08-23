// script.js
var menuBtn = document.getElementById("menuBtn");
var sideNav = document.getElementById("sideNav");
var menu = document.getElementById("menu");

sideNav.style.right = "-250px";
menuBtn.onclick = function () {
    if (sideNav.style.right == "-250px") {
        sideNav.style.right = "0";
        menu.src = "images/close.png";
        sideNav.classList.add('visible');
    } else {
        sideNav.style.right = "-250px";
        menu.src = "images/menu.png";
        sideNav.classList.remove('visible');
    }
}

document.addEventListener('click', function (event) {
    if (!sideNav.contains(event.target) && !menuBtn.contains(event.target) && sideNav.classList.contains('visible')) {
        sideNav.style.right = "-250px";
        menu.src = "images/menu.png";
        sideNav.classList.remove('visible');
    }
});

// Add event listeners to menu items to close sideNav when clicked
var menuItems = document.querySelectorAll("#sideNav ul li a");
menuItems.forEach(function(item) {
    item.addEventListener('click', function() {
        sideNav.style.right = "-250px";
        menu.src = "images/menu.png";
        sideNav.classList.remove('visible');
    });
});

// All animations will take exactly 1000ms
var scroll = new SmoothScroll('a[href*="#"]', {
    speed: 1000,
    speedAsDuration: true
});
