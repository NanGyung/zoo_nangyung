import { ajax } from '/js/ajax.js';

const $bbscId = document.getElementById('bbscId');
const $userNick = document.getElementById('userNick');
const $ccContent = document.getElementById('ccContent');
const $ccId = document.getElementById('ccId');

// 수정 화면으로 가기
const $modifyBtn = document.getElementById('modifyBtn');

$modifyBtn?.addEventListener('click', e => {
   const url = `/bbsc/${$bbscId.value}/edit`;
   location.href = url;
});

// 삭제
const $delBtn = document.getElementById('delBtn');
$delBtn?.addEventListener('click', e => {
  if(confirm('삭제하시겠습니까?')){
    const url = `/bbsc/${$bbscId.value}/del`;
    location.href = url;
  }
});

//댓글 등록버튼
const $addBtn = document.getElementById('addBtn');
//댓글 취소버튼
const $cancelBtn = document.getElementById('cancelBtn');

// 페이지 새로고침
function resetPage(){
    const url = `/bbsc/${$bbscId.value}/detail`;
    location.href= url;
}

//댓글 등록
const add_h = e => {
   $ccContent.disabled == false;
   const url = '/api/bbscReply/save';
   const payLoad = {
    "bbscId": $bbscId.value,
    "ccContent":$ccContent.value,
    "userNick": $userNick.textContent
   };
    ajax
       .post(url, payLoad)
       .then(res => res.json())
       .then(resetPage)
       .catch(console.error); //err=>console.error(err)
       return;

}

$addBtn.addEventListener('click',add_h,false);

//댓글 등록취소
$cancelBtn.addEventListener('click',e => {
   $ccContent.disabled == true;
    $ccContent.textContent = '';
},false);

//댓글 삭제버튼
const $replyDelBtn = document.getElementById('replyDelBtn');
const del_h = e => {
    const url = `/api/bbscReply/del/${$ccId.textContent}`;
     if(confirm('삭제하시겠습니까?')){
        ajax
            .delete(url)
            .then(res => res.json)
            .then(resetPage)
            .error(console.error);
     }

}
$replyDelBtn.addEventListener('click', del_h, false);

