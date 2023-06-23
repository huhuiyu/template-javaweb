let qs = location.search;
qs = qs.length < 1 ? '' : qs.substring(1);
let message = qs.replace('message=', '');
console.log(location.search, qs, message);
if (message) {
  message = decodeURIComponent(message);
  alert(message);
}
