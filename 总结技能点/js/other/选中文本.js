function getSelectedText(){
	var selectedText;
	if(window.getSelection){
		selectedText=window.getSelection();
	}else{
		selectedText=document.selection.createRange().text;
	}
	return selectedText;
}