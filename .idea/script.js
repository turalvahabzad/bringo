document.addEventListener('DOMContentLoaded', function() {
    var footer = document.querySelector('.footer');
    var mainContent = document.querySelector('.main-content');
    var spacer = document.createElement('div');
    spacer.classList.add('spacer');
    mainContent.appendChild(spacer);

    window.addEventListener('scroll', function() {
        var scrollPosition = window.scrollY;
        var windowHeight = window.innerHeight;
        var bodyHeight = document.body.offsetHeight;
        var footerHeight = footer.offsetHeight;

        // Calculate how far the user has scrolled from the top
        var scrolledPercentage = (scrollPosition / (bodyHeight - windowHeight)) * 100;

        // Show the footer if the user has scrolled past a certain percentage
        if (scrolledPercentage >= 80) {
            footer.style.display = 'block';
            spacer.style.height = footerHeight + 'px';
        } else {
            footer.style.display = 'none';
            spacer.style.height = 0;
        }
    });
});
