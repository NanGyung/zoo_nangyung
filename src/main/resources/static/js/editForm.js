// 수정 등록
const $addBtn = document.getElementById('addBtn');
$addBtn.addEventListener('click', e => {
    editForm.action = `${editForm.action}`;
    editForm.submit();
});

// 취소
const $cancleBtn = document.getElementById('cancleBtn');
$cancleBtn.addEventListener('click', e => {
    const url = `/bbsc/${bbscId.value}/detail`;
    location.href = url;
});