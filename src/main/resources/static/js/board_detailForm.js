import { ajax } from '/js/ajax.js';

const $bbscId = document.getElementById('bbscId');
const $userNick = document.getElementById('userNick');
const $ccContent = document.getElementById('ccContent');

// ���� ȭ������ ����
const $modifyBtn = document.getElementById('modifyBtn');

$modifyBtn?.addEventListener('click', e => {
   const url = `/bbsc/${$bbscId.value}/edit`;
   location.href = url;
});

// ����
const $delBtn = document.getElementById('delBtn');
$delBtn?.addEventListener('click', e => {
  if(confirm('�����Ͻðڽ��ϱ�?')){
    const url = `/bbsc/${$bbscId.value}/del`;
    location.href = url;
  }
});

//��� ��Ϲ�ư
const $addBtn = document.getElementById('addBtn');
//��� ��ҹ�ư
const $cancelBtn = document.getElementById('cancelBtn');

//��� ���
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
       .catch(console.error); //err=>console.error(err)
       return;
}

$addBtn.addEventListener('click',add_h,false);

//��� ������
$cancelBtn.addEventListener('click',e => {
   $ccContent.disabled == true;
},false);

