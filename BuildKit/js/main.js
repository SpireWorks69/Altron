const area = new Canvas(document.getElementById('area'));

let vector;
let value;

document.addEventListener('keypress', function(e) {
    if(e.key.toLowerCase() == 'c') {
        area.clear();
    }

    if(!isResultExists && e.key.toLowerCase() == 'v') {
        vector = area.calculate(true);
        value = document.getElementById('input').value;
        isResultExists = true;
    }
});