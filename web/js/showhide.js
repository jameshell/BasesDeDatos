function yesnoCheck() {
    if (document.getElementById('yesCheck').checked) {
        document.getElementById('ifYes').style.visibility = 'visible';
    }
    else document.getElementById('ifYes').style.visibility = 'hidden';
    
    if (document.getElementById('noCheck').checked) {
        document.getElementById('ifNo').style.visibility = 'visible';
    }
    else document.getElementById('ifNo').style.visibility = 'hidden';


}