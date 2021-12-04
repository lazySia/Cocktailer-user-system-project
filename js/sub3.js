$(document).ready(function () {
  $(document).ready(function () {
    $("#trigger").click(function (e) {
      e.preventDefault();
      $(this).toggleClass("active");
      $("#mainmenu").toggleClass("active");
    });
  });

  /* 탭메뉴*/
  $("ul.tabs li").click(function () {
    var tab_id = $(this).attr("data-tab");

    $("ul.tabs li").removeClass("current");
    $(".tab-content").removeClass("current");

    $(this).addClass("current");
    $("#" + tab_id).addClass("current");
  });

  /*datepicker    */
  $(".datebox").click(function () {
    $("#date").datepicker({
      dateFormat: "yymmdd", // 데이터 포멧 , 20120905 형식
      minDate: +0,
    });

    $("#date").focus();
  });

  /*
      $('.arrow-up').click(functino())
  
      $('.arrow-down').click(function())
  */
});
