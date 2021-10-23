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
