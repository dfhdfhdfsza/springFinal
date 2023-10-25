document.getElementById('fileMod').addEventListener('click',()=>{
    let uuid=document.getElementById('fileMod').dataset.uuid;
    console.log(uuid);

    FileModifyDelete(uuid).then(result=>{
        if(result==1){
            window.location.reload()
        }
    })
})

async function FileModifyDelete(uuid)
{
    try {
        const url='/board/'+uuid;
        const config={
            method:'delete'
        };
        const resp=await fetch(url,config);
        const result=await resp.text;
        return result;
    } catch (error) {
        console.log(error);
    }
}

document.getElementById('trigger').addEventListener('click',()=>{
    document.getElementById('files').click();
});

//실행파일, 이미지 파일에 대한 정규표현식 작성
const regExp=new RegExp("\.(exe|sh|bat|js|msi|dll)$"); //실행 파일 막기
const regExpImg=new RegExp("\.(jpg|jpeg|png|gif)"); //허용할 이미지 파일
const maxSize = 1024*1024*20; //파일 최대 크기

function fileValidation(fileName,fileSize)
{
    if(!regExpImg.test(fileName))
        return 0;
    else if(regExp.test(fileName))
        return 0;
    else if(fileSize>maxSize)
        return 0;
    else
        return 1;

}
//객체에 변화가 생겼을때
document.addEventListener('change',(e)=>{
    if(e.target.id=='files'){
        
        //input file element에 저장된 file의 정보를 가져오는 property
        const fileObj = document.getElementById('files').files;
        console.log(fileObj);

        //첩투파일에 대한 정보를 fileZone에 기록 
        let div=document.getElementById('fileZone');
        
        div.innerHTML="";//기존 값이 있다면 삭제
        //ul=>li로 첨부파일 추가
        //<ul class="list-group"></ul>
        //<li class="list-group-item">An item</li>
        let isOk=1;
        let ul=`<ul class="list-group list-group-flush">`;
        for(let file of fileObj)
        {
            let validResult=fileValidation(file.name,file.size); //0또는 1
            isOk*=validResult;
            ul+=`<li class="list-group-item">`;
            ul+=`<div class="mb-3">`;
            ul+=`${validResult ? '<div class="mb-3">업로드 가능</div>':'<div class="mb-3 text-danger">업로드 가능</div>'}`;
            ul+=`${file.name}</div>`;
            ul+=`<span class="badge text-bg-${validResult ? 'success':'danger'}">${file.size}Bytes</span></li>`;
        }
        ul+=`</ul>`;
        div.innerHTML=ul;

    
    }
})