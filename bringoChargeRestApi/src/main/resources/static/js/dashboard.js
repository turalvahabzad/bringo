// JavaScript for Dashboard Functionality

// Sidebar toggle functionality (optional, if you'd like to implement a responsive toggle)
const sidebar = document.querySelector('.sidebar');
const sidebarMenuItems = document.querySelectorAll('.sidebar-menu li');

sidebarMenuItems.forEach(item => {
    item.addEventListener('click', () => {
        sidebarMenuItems.forEach(el => el.classList.remove('active'));
        item.classList.add('active');
    });
});
