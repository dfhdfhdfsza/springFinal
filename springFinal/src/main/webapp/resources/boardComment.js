console.log(bnoVal);

async function postCommentToServer(cmtData)
{
    try {
        const url='/comment/post';
        const config={
            method:"post",
            headers:{
                'content-type':'application/json; charset=utf-8'
            },
            body:JSON.stringify(cmtData)
        };
        const resp=await fetch(url,config);
        const result=await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

document.getElementById('cmtPostBtn').addEventListener('click',()=>{
    let cmtWriter=document.getElementById('cmtWriter').innerText;
    let cmtText=document.getElementById('cmtText').value;
    
    let cmtData={
        bno:bnoVal,
        writer:cmtWriter,
        content:cmtText
    };
    console.log(cmtData);
    document.getElementById('cmtText').value="";

    postCommentToServer(cmtData).then(result=>{
        if(result==1){
            alert("댓글 등록 성공");
            getCommentList(bnoVal);
        }
    })
})

async function spreadCommentListFromServer(bno,page)
{
    try {
        const resp=await fetch('/comment/'+bno+'/'+page);
        const result=await resp.json();
        return result;
    } catch (error) {
        console.log(error);
    }
}

//무조건 처음 뿌릴때는 첫페이지 값을 뿌려야함
function getCommentList(bno,page=1)
{
    spreadCommentListFromServer(bno,page).then(result=>{
        console.log(result);//ph 객체 pgvo,totalCount,cmtList

        let tbody=document.getElementById('cmtArea');
        if(result.cmtList.length>0)
        {
            if(page==1){
                //다시 댓글을 뿌릴때 기존 값 삭제 1page일 경우만
                tbody.innerHTML="";
            }
            for(let i=0;i<result.cmtList.length;i++)
            {
                let str=`<tr data-cno="${result.cmtList[i].cno}" data-content="${result.cmtList[i].content}">`;
                str+=`<td>${result.cmtList[i].cno}</td>`;
                str+=`<td>${result.cmtList[i].writer}</td>`;
                str+=`<td>${result.cmtList[i].content}</td>`;
                str+=`<td>${result.cmtList[i].modAt}</td>`
                str+=`<td><button type="button" class="modBtn" data-bs-toggle="modal" data-bs-target="#myModal">%</button></td>`
                str+=`<td><button type="button" class="delBtn">x</button></td>`
                str+=`</tr>`;
                tbody.innerHTML+=str;
            }
        }
        else{
            let str=`<tr><td colspan="6">Comment List Empty</td></tr>`;
            tbody.innerHTML+=str;
        }
        //댓글 페이징 코드
        // let moreBtn=document.getElementById('moreBtn');
        console.log(moreBtn);
        //db에서 pgvo + list 같이 가져와야 값을 줄 수 있음
        if(result.pgvo.pageNo<result.endPage||result.next)
        {
            moreBtn.style.visibility='visible';
            // moreBtn.dataset.page=page+1;
        }
        else{
            moreBtn.style.visibility='hidden'; //버튼 숨김
        }
        
    })
}


document.addEventListener('click',(e)=>{
    if(e.target.classList.contains('delBtn'))
    {
        console.log('삭제버튼 클릭');
        let tr=e.target.closest('tr');
        let cnoVal=e.target.dataset.cno;
        console.log(tr);
        console.log(cnoVal);
        
        
        removeCommentToServer(cnoVal).then(result=>{
            if(result==1)
                alert('댓글 삭제 성공!');
            
            getCommentList(bnoVal);
        })

    }
    else if(e.target.classList.contains('modBtn'))
    {
        let tr=e.target.closest('tr');
        console.log(tr);
        //nextSibling:같은 부모의 다음 형제 객체를 반환
        let cmtText=tr.dataset.content;
        console.log(cmtText);

        //cmtModBtn에 data-cno달기
        document.getElementById('cmtTextMod').value=cmtText;
        document.getElementById('cmtModBtn').setAttribute('data-cno',tr.dataset.cno);

    }
    else if(e.target.id=='cmtModBtn')
    {
        let cmtDataMod={
            cno:e.target.dataset.cno,
            content:document.getElementById('cmtTextMod').value
        };
        console.log(cmtDataMod);
        editCommentToServer(cmtDataMod).then(result=>{
            if(result == 1)
            {
                //모달창 닫기
                document.querySelector('.btn-close').click();
                getCommentList(bnoVal);
            }
        })
    }
    else if(e.target.id=='moreBtn')
    {
        let moreBtn=document.getElementById('moreBtn');
        let page=moreBtn.dataset.page;
        moreBtn.dataset.page=parseInt(page)+1;
        getCommentList(bnoVal,parseInt(e.target.dataset.page));
    }
})

async function removeCommentToServer(cno)
{
    try {
        const url='/comment/'+cno;
        const config={
            method:'delete'
        };
        const resp=await fetch(url,config);
        const result=await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

async function editCommentToServer(cmtData)
{
    try {
        const url='/comment/'+cmtData.cno;
        const config={
            method:'put',
            headers:{
                'Content-Type':'application/json; charset=utf-8'
            },
            body:JSON.stringify(cmtData)
        };
        const resp=await fetch(url,config);
        const result=await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}