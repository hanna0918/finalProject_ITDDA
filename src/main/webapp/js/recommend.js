$("#recommendSubmitBtn").click(function () {
  if (tag.length < 5) {
    $("#hiddenTagAllDone").css("display", "block");
    $("#hiddenTagAllDone").text("태그를 5개 이상 작성해주세요");
    return false;
  }

  $("#searchText").prop("disabled", true);
  $("#recommendWriteOk").attr("onsubmit", "");

  $("#recommendWriteOk").submit();
});

// 배열  선언
var tag = new Array();

// Text 이벤트리스너
const searchTextArea = document.querySelector("#searchText");
// searchTextArea.addEventListener("keyup", keyupTest);

// 태그 배열에 값 넣기
function keyupTest(e) {
  const keyCode = e.keyCode;
  if (tag.length < 5) {
    if (keyCode == 32 || keyCode == 13) {
      text = searchTextArea.value;
      searchTextArea.value = "";
      if (text == "" || text == " ") {
        // 여기에 그............ 그....... 버블? 로 글을 쓰라고 말하기(태그를 입력하고 엔터나 스페이스를 누르세요)
        return;
      }
      tag.push(text.trim());
      eraseAllTag();
      tagInValue();
      sendWithAjax();
    }
  }
}

// 배열 값 빼기
function eraseTag() {
  const indexNo = parseInt(this.id.slice(9));
  tag.splice(indexNo, 1);
  document.querySelector(`#hiddenTag${indexNo}`).style.display = "none";
  eraseAllTag();
  tagInValue();
  sendWithAjax();
}

// 태그일괄 지우기
function eraseAllTag() {
  for (i = 0; i < 5; i++) {
    document.querySelector(`#hiddenTag${i}`).style.display = "none";
    document.querySelector(`#hiddenTag${i}`).innerHTML = "";
  }
}

// 태그에 값 넣는 펑션 태그에 값이 있다는 가정하에
function tagInValue() {
  for (i = 0; i < tag.length; i++) {
    document.querySelector(`#hiddenTag${i}`).innerHTML = "#" + tag[i];
    document.querySelector(`#hiddenTag${i}`).style.display = "block";
  }
}

var data = "";
var nowPage = 1;

var totalPg = 1;
var oneRec = 1;
var totalRec = 1;

function sendWithAjax() {
  data = "";
  if (tag != null && tag != "") {
    data += "tag=" + tag;
  }

  data += "&nowPage=" + nowPage;

  var data = data;
  var rUrl = "/itda/recommendListTagSearch";
  console.log(data);
  $.ajax({
    type: "POST",
    url: rUrl,
    data: data,
    success: function (result) {
      var listResult = $(result.vo);
      var pageResult = $(result.pVo);
      var newList = "";
      var newPageNum = "";
      if (listResult.length != 0) {
        listResult.each(function (idx, vo) {
          var splitTag = vo.board_select.split("/");
          newList += `<div>${vo.board_seq}</div>`;
          newList += `<div class="recommendContent">`;
          newList += `<div>`;
          newList += `<img src="/itda/img/${vo.i_url}" class="chucheonImg" />`;
          newList += `</div>`;
          newList += `<div class="contentInfo">`;
          newList += `<div>`;
          newList += `<a href="/itda/recommendView?board_seq=${vo.board_seq}">${vo.board_subject}</a>`;
          newList += `</div>`;
          newList += `<span class="tagspan">`;
          for (i = 0; i < splitTag.length; i++) {
            newList += `#${splitTag[i]} `;
          }
          newList += `</span>`;
          newList += `<div>`;
          newList += `<div>${vo.m_nickname}</div>`;
          newList += `<div>${vo.board_writedate}</div>`;
          newList += `<div>조회수 ${vo.board_hit}</div>`;
          newList += `<div>`;
          newList += `<img src="img/recommend.png" class="recommendImg" /> <span>${vo.b_goodhit}</span>`;
          newList += `</div>`;
          newList += `<div>`;
          newList += `<img src="img/siren3.png" class="commentImg" /> <span>${vo.board_call}</span>`;
          newList += `</div>`;
          newList += `</div>`;
          newList += `</div>`;
          newList += `</div>`;
          newList += `<div>`;
          newList += `<img src="img/replImg.png" class="commentImg" /> ${vo.br_cnt}`;
          newList += `</div>`;
        });
      } else {
        newList += `<img src="/itda/img/teong.jpg" alt="텅" width="100%"/>`;
      }
      if (listResult.length != 0) {
        pageResult.each(function (idx, pVo) {
          if (pVo.nowPage > 1) {
            newPageNum += "<li class='page-item'><a href='javascript:recommendPagingPrev()' class='page-link'>◁</a></li>";
          }
          if (pVo.nowPage == 1) {
            newPageNum += "<li class='page-item'><a class='page-link'>◁</a></li>";
          }
          for (i = pVo.startPage; i <= pVo.startPage + pVo.onePageNumCount - 1; i++) {
            if (i <= pVo.totalPage) {
              if (i == pVo.nowPage) {
                newPageNum += "<li class='page-item' id='activePage'>";
              }
              if (i != pVo.nowPage) {
                newPageNum += "<li class='page-item'>";
              }
              newPageNum += "<a href='javascript:recommendPaging(" + i + ")'>" + i + "</a></li>";
            }
          }
          if (pVo.nowPage < pVo.totalPage) {
            newPageNum += "<li class='page-item'><a href='javascript:recommendPagingNext()'>▷</a></li>";
          }
        });
      }
      $(".chucheonList").html(newList);
      $(".pagingDiv").html(newPageNum);
    },
    error: function () {
      console.log("ajax error!!!!!!!!!!!!!");
    },
  });
}

// 태그 지우는 이벤트리스너
const hiddenTagDiv0 = document.querySelector("#hiddenTag0");
const hiddenTagDiv1 = document.querySelector("#hiddenTag1");
const hiddenTagDiv2 = document.querySelector("#hiddenTag2");
const hiddenTagDiv3 = document.querySelector("#hiddenTag3");
const hiddenTagDiv4 = document.querySelector("#hiddenTag4");
// hiddenTagDiv0.addEventListener("click", eraseTag);
// hiddenTagDiv1.addEventListener("click", eraseTag);
// hiddenTagDiv2.addEventListener("click", eraseTag);
// hiddenTagDiv3.addEventListener("click", eraseTag);
// hiddenTagDiv4.addEventListener("click", eraseTag);

// 페이징
function recommendPaging(pageNumber, totalPg, oneRec, totalRec) {
  this.nowPage = pageNumber;

  this.totalPg = totalPg;
  this.oneRec = oneRec;
  this.totalRec = totalRec;
  sendWithAjax();
}
// 페이징 Next
function recommendPagingNext() {
  nowPage += 1;
  sendWithAjax();
}
// 페이징 Prev
function recommendPagingPrev() {
  nowPage -= 1;
  sendWithAjax();
}
