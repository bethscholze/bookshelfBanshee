const init = () => {
    let editButton = document.querySelector(".editBook");
    // grabs the session variable from java
    //var userBooks = '<%= session.getAttribute("userBooks") %>';
    console.log("init ran");
    editButton.addEventListener("click", getDetails(this));
    //get isbn for this item and pass it to get details

}

const setBook = (book) => {
    //
    //currentbook = userBook.id== to passed in id form function call
    let currentBook = book;
    console.log(currentBook);

}

window.onload = init;