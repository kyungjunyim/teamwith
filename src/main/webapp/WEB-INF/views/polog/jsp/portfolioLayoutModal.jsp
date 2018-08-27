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
.btn_color {
	width: 140px;
	padding: 0px 10px;
	font-size: 23px;
	color: #002b5a;
	background-color: #ffffff;
	border-color: #002b5a;
	
}
.btn_color:hover {
	 background-color: #f7e7e3; 
	
}
</style>

<style>
.like-content {
    display: inline-block;
    width: 100%;
    margin: 40px 0 0;
    padding: 40px 0 0;
    font-size: 18px;
    border-top: 10px dashed #eee;
    text-align: center;
}
.like-content span {
    color: #9d9da4;
    font-family: monospace;
}
.like-content .btn-secondary {
      display: block;
      margin: 40px auto 0px;
    text-align: center;
    background: #ed2553;
    border-radius: 3px;
    box-shadow: 0 10px 20px -8px rgb(240, 75, 113);
    padding: 10px 17px;
    font-size: 18px;
    cursor: pointer;
    border: none;
    outline: none;
    color: #ffffff;
    text-decoration: none;
    -webkit-transition: 0.3s ease;
    transition: 0.3s ease;
}
.like-content .btn-secondary:hover {
      transform: translateY(-3px);
}
.like-content .btn-secondary .fa {
      margin-right: 5px;
}
.animate-like {
    animation-name: likeAnimation;
    animation-iteration-count: 1;
    animation-fill-mode: forwards;
    animation-duration: 0.65s;
}
@keyframes likeAnimation {
  0%   { transform: scale(30); }
  100% { transform: scale(1); }
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
		<div class="like-content"><button type="button" class="btn btn-md btn_submit btn_color bb" data-dismiss="modal" id="okbtn">OK</button></div> 
        <button type="button" class="btn btn-md btn_cancel btn_color" data-dismiss="modal" id="closebtn">Cancel</button> 
      </div>
    </div>

  </div>
</div>
<script>
$(function(){
    $(document).one('click', '.bb', function(e) {
        $(this).html('<i class="fa fa-heart" aria-hidden="true"></i> You liked this');
        $(this).children('.fa-heart').addClass('animate-like');
    });
});
</script>