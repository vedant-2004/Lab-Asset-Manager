// dashboard.js

// Animate sections on page load
document.addEventListener("DOMContentLoaded", function () {
    const sections = document.querySelectorAll(".dashboard-section");
    sections.forEach((section) => {
        section.classList.add("visible");
    });
});

// Spinner functions
function showSpinner() {
    const spinner = document.getElementById("loading-spinner");
    if (spinner) spinner.classList.remove("hidden");
}
function hideSpinner() {
    const spinner = document.getElementById("loading-spinner");
    if (spinner) spinner.classList.add("hidden");
}

// Sidebar toggle
const toggleBtn = document.getElementById("menu-toggle");
if (toggleBtn) {
    toggleBtn.addEventListener("click", function () {
        const sidebar = document.querySelector(".sidebar");
        if (sidebar) sidebar.classList.toggle("open");
    });
}
