<style>
.layout_modal_row{
	text-align:center;
	width:33%;
	float:left;
}
.layoutpic{
		width:70%;
		height:100%;
		
	}
.layoutbtn{
	border-style: none;
	background-color: white;
	
}
.layoutbtn{
	width:100%;
	height:100%;
	text-align:center;
	cursor:pointer;
}
	
.layoutbtn:hover {
	color: #ff4111;
	background-color: #f7e7e3;
	border-color: #ff4111;
}
</style>
<div id="myModal" class="modal fade" role="dialog" >
  <div class="modal-dialog" style="margin:0 auto;margin-top:5%;max-width:50%">

    <!-- Modal content-->
    <div class="modal-content" style="width:100%">
      <div class="modal-header">
		<h4 class="modal-title" style="margin:0 auto">Select Layout</h4>        
      </div>
      <div class="modal-body">
        <div class="row">
        	<div class="layout_modal_row">
        		<button type="button" class="layoutbtn" id="l1-1btn"><img class="layoutpic" src="/resources/image/layout1-1.png"/></button>
        	</div>
        	<div class="layout_modal_row">
        		<button type="button" class="layoutbtn" id="l1-2btn"><img class="layoutpic" src="/resources/image/layout1-2.png"/></button>
        	</div>
        	<div class="layout_modal_row">
        		<button type="button" class="layoutbtn"id="l1-3btn"><img class="layoutpic" src="/resources/image/layout1-3.png"/></button>
        	</div>
        	
        </div>
        <div class="row" style="margin-top:4%">
        	<div class="layout_modal_row">
        		<button type="button" class="layoutbtn"id="l2-1btn"><img class="layoutpic" src="/resources/image/layout2-1.png"/></button>
        	</div>
        	<div class="layout_modal_row">
        		<button type="button" class="layoutbtn"id="l2-2btn"><img class="layoutpic" src="/resources/image/layout2-2.png"/></button>
        	</div>
        	<div class="layout_modal_row">
        		<button type="button" class="layoutbtn" id="l2-3btn"><img class="layoutpic" src="/resources/image/layout2-3.png"/></button>
        	</div>
        	
        </div>
      </div>
      <div class="modal-footer">
		<button type="button" class="btn btn-md btn_submit btn_color" data-dismiss="modal" id="okbtn">OK</button> 
        <button type="button" class="btn btn-md btn_cancel btn_color" data-dismiss="modal" id="closebtn">Cancel</button> 
      </div>
    </div>

  </div>
</div>