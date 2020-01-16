function hide(id) {
    if (document.getElementById) {
        if (document.getElementById(id).style.display === 'block') {
            document.getElementById(id).style.display = 'none';
        }
    }
}
function view(id) {
    if (document.getElementById)  {
        if (document.getElementById(id).style.display === 'none') {
            document.getElementById(id).style.display = 'block';
        } else {}
    }
}
