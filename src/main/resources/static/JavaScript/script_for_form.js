document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("addItemForm");

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    const description = document.getElementById("description").value.trim();
    const admin = document.getElementById("admin").value.trim();
    const from_date = document.getElementById("from_date").value.trim();
    const to_date = document.getElementById("to_date").value.trim();

    if (description === "") {
      alert("Please enter a description.");
      return; // Stop form submission if description is empty
    }

    if (admin === "") {
      alert("Please select an admin.");
      return; // Stop form submission if admin is not selected
    }

    if (from_date === "" || to_date === "") {
      alert("Please select both start and end dates.");
      return; // Stop form submission if any date is not selected
    }

    // If all validations pass, submit the form
    form.submit();
  });
});
