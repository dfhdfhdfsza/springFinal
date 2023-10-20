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

    postCommentToServer(cmtData).then(result=>{
        if(result==1){
            alert("댓글 등록 성공");
            getCommentList(bnoVal);
        }
    })
})

async function spreadCommentListFromServer(bno)
{
    try {
        const resp=await fetch('/comment/'+bno);
        const result=await resp.json();
        return result;
    } catch (error) {
        console.log(error);
    }
}


function getCommentList(bno)
{
    spreadCommentListFromServer(bno).then(result=>{
        console.log(result);

        let tbody=document.getElementById('cmtArea');
        if(result.length>0)
        {
            tbody.innerHTML="";
            for(let i=0;i<result.length;i++)
            {
                let str=`<tr data-cno="${result[i].cno}">`;
                str+=`<td>${result[i].cno}</td>`;
                str+=`<td>${result[i].writer}</td>`;
                str+=`<td>${result[i].content}</td>`;
                str+=`<td>${result[i].regAt}</td>`
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