document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("addItemForm");

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    const userID = document.getElementById("userID").value.trim();
    const description = document.getElementById("description").value.trim();
    const from_date = document.getElementById("from_date").value.trim();
    const to_date = document.getElementById("to_date").value.trim();

    if (
      userID !== "" &&
      description !== "" &&
      from_date !== "" &&
      to_date !== ""
    ) {
      const leaveID = Math.floor(1000 + Math.random() * 9000);

      window.opener.postMessage(
        {
          leaveID: leaveID,
          userID: userID,
          description: description,
          from_date: from_date,
          to_date: to_date,
        },
        "*"
      );

      window.close();
    } else {
      alert("Please Fill in All the Fields.");
    }
  });
});
