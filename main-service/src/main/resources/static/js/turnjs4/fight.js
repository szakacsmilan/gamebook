const Http = new XMLHttpRequest();
const url='http://localhost:9091/figth/lizard';
Http.open("GET", url);
Http.send();

Http.onreadystatechange = (e) => {
    console.log(Http.responseText)
}