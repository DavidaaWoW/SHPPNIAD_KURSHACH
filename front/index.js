function load_items() {
  let url = "http://192.168.43.127:8080/category/all";
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open("GET", url, false);
  xmlHttp.send();
  let items = JSON.parse(xmlHttp.responseText);

  let parent = document.getElementsByClassName("items");
  items.forEach((element) => {
    let item = document.createElement("div");
    let img = document.createElement("img");
    let p = document.createElement("p");
    let a = document.createElement("a");
    a.setAttribute("href", "/dishes.html?" + "id=" + element.id);
    p.innerHTML = element.name;
    img.setAttribute("src", element.imageLink);
    item.className = "item";
    parent[0].appendChild(item);
    item.appendChild(a);
    a.appendChild(img);
    a.appendChild(p);
  });
}

function load_dishes() {
  let url =
    "http://192.168.43.127:8080/category/" +
    window.location.search.slice(4) +
    "/all";
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open("GET", url, false);
  xmlHttp.send();
  let items = JSON.parse(xmlHttp.responseText);

  let parent = document.getElementsByClassName("items");
  items.forEach((element) => {
    let item = document.createElement("div");
    let img = document.createElement("img");
    let p1 = document.createElement("p");
    let p2 = document.createElement("p");
    let p3 = document.createElement("p");
    p1.innerHTML = element.name;
    p2.innerHTML = element.description;
    p3.innerHTML = "Цена: " + element.price + "р.";
    img.setAttribute("src", element.imageLink);
    item.className = "item";
    parent[0].appendChild(item);
    item.appendChild(img);
    item.appendChild(p1);
    item.appendChild(p2);
    item.appendChild(p3);
  });
}
