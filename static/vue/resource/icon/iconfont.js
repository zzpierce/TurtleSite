;(function(window) {

  var svgSprite = '<svg>' +
    '' +
    '<symbol id="icon-close" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M176.661601 817.172881C168.472798 825.644055 168.701706 839.149636 177.172881 847.338438 185.644056 855.527241 199.149636 855.298332 207.338438 846.827157L826.005105 206.827157C834.193907 198.355983 833.964998 184.850403 825.493824 176.661601 817.02265 168.472798 803.517069 168.701706 795.328267 177.172881L176.661601 817.172881Z"  ></path>' +
    '' +
    '<path d="M795.328267 846.827157C803.517069 855.298332 817.02265 855.527241 825.493824 847.338438 833.964998 839.149636 834.193907 825.644055 826.005105 817.172881L207.338438 177.172881C199.149636 168.701706 185.644056 168.472798 177.172881 176.661601 168.701706 184.850403 168.472798 198.355983 176.661601 206.827157L795.328267 846.827157Z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-comments" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M131.253515 789.333333C87.810305 789.333333 52.51282 753.473975 52.51282 709.41763L52.51282 69.333333 26.25641 96 892.853331 96C936.231586 96 971.487179 131.853286 971.487179 175.915703L971.487179 816 997.74359 789.333333 525.128205 789.333333 517.234323 789.333333 510.649171 793.754413 285.912493 944.636066C273.815607 952.757562 270.491629 969.301024 278.488179 981.586923 286.484727 993.872821 302.773675 997.248736 314.87056 989.127241L539.607238 838.245587 525.128205 842.666667 997.74359 842.666667 1024 842.666667 1024 816 1024 175.915703C1024 102.41369 965.24899 42.666667 892.853331 42.666667L26.25641 42.666667 0 42.666667 0 69.333333 0 709.41763C0 782.925715 58.804881 842.666667 131.253515 842.666667L268.117303 842.666667C282.618319 842.666667 294.373713 830.727593 294.373713 816 294.373713 801.272407 282.618319 789.333333 268.117303 789.333333L131.253515 789.333333Z"  ></path>' +
    '' +
    '<path d="M367.589743 442.666667C367.589743 383.756294 320.568162 336 262.564102 336 204.560043 336 157.538461 383.756294 157.538461 442.666667 157.538461 501.577039 204.560043 549.333333 262.564102 549.333333 320.568162 549.333333 367.589743 501.577039 367.589743 442.666667ZM210.051282 442.666667C210.051282 413.211479 233.562074 389.333333 262.564102 389.333333 291.566133 389.333333 315.076924 413.211479 315.076924 442.666667 315.076924 472.121854 291.566133 496 262.564102 496 233.562074 496 210.051282 472.121854 210.051282 442.666667Z"  ></path>' +
    '' +
    '<path d="M630.153845 442.666667C630.153845 383.756294 583.132265 336 525.128205 336 467.124145 336 420.102564 383.756294 420.102564 442.666667 420.102564 501.577039 467.124145 549.333333 525.128205 549.333333 583.132265 549.333333 630.153845 501.577039 630.153845 442.666667ZM472.615386 442.666667C472.615386 413.211479 496.126176 389.333333 525.128205 389.333333 554.130236 389.333333 577.641026 413.211479 577.641026 442.666667 577.641026 472.121854 554.130236 496 525.128205 496 496.126176 496 472.615386 472.121854 472.615386 442.666667Z"  ></path>' +
    '' +
    '<path d="M892.717948 442.666667C892.717948 383.756294 845.696367 336 787.692307 336 729.688247 336 682.666667 383.756294 682.666667 442.666667 682.666667 501.577039 729.688247 549.333333 787.692307 549.333333 845.696367 549.333333 892.717948 501.577039 892.717948 442.666667ZM735.179488 442.666667C735.179488 413.211479 758.690278 389.333333 787.692307 389.333333 816.694338 389.333333 840.205129 413.211479 840.205129 442.666667 840.205129 472.121854 816.694338 496 787.692307 496 758.690278 496 735.179488 472.121854 735.179488 442.666667Z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-delete" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M972.657609 209.348408C987.158609 209.36839 998.930114 197.571202 998.949999 182.99865 998.969882 168.426097 987.230618 156.59651 972.729617 156.576528L32.457975 155.280806C17.956974 155.260823 6.18547 167.058012 6.165585 181.630564 6.1457 196.203116 17.884965 208.032703 32.385966 208.052686L972.657609 209.348408Z"  ></path>' +
    '' +
    '<path d="M180.466902 992.356169 180.466902 1019.014859 206.993296 1018.74074 833.361858 1012.267947 859.348284 1011.999407 859.348284 985.883377 859.348284 289.397297C859.348284 274.824732 847.59289 263.011332 833.091874 263.011332 818.590859 263.011332 806.835465 274.824732 806.835465 289.397297L806.835465 985.883377 832.82189 959.498805 206.453329 965.971599 232.979723 992.356169 232.979723 282.67005C232.979723 268.097483 221.224329 256.284085 206.723313 256.284085 192.222298 256.284085 180.466902 268.097483 180.466902 282.67005L180.466902 992.356169Z"  ></path>' +
    '' +
    '<path d="M656.410257 847.079027C656.410257 861.651593 668.165651 873.464992 682.666667 873.464992 697.167682 873.464992 708.923076 861.651593 708.923076 847.079027L708.923076 372.131659C708.923076 357.559091 697.167682 345.745694 682.666667 345.745694 668.165651 345.745694 656.410257 357.559091 656.410257 372.131659L656.410257 847.079027Z"  ></path>' +
    '' +
    '<path d="M341.333333 847.079027C341.333333 861.651593 353.08873 873.464992 367.589743 873.464992 382.090758 873.464992 393.846155 861.651593 393.846155 847.079027L393.846155 372.131659C393.846155 357.559091 382.090758 345.745694 367.589743 345.745694 353.08873 345.745694 341.333333 357.559091 341.333333 372.131659L341.333333 847.079027Z"  ></path>' +
    '' +
    '<path d="M498.871795 847.079027C498.871795 861.651593 510.627189 873.464992 525.128205 873.464992 539.62922 873.464992 551.384614 861.651593 551.384614 847.079027L551.384614 372.131659C551.384614 357.559091 539.62922 345.745694 525.128205 345.745694 510.627189 345.745694 498.871795 357.559091 498.871795 372.131659L498.871795 847.079027Z"  ></path>' +
    '' +
    '<path d="M392.147755 116.721777C392.147755 102.063669 403.758665 90.363507 418.40134 90.363507L622.925796 90.363507C637.408947 90.363507 649.179381 102.1619 649.179381 116.549585L649.179381 171.644875 701.692203 171.644875 701.692203 116.549585C701.692203 72.986607 666.38105 37.591577 622.925796 37.591577L418.40134 37.591577C374.724427 37.591577 339.634933 72.950804 339.634933 116.721777L339.634933 165.310801 392.147755 165.310801 392.147755 116.721777Z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-edit" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M34.155089 230.940227 9.17948 230.940227 9.17948 256.203386 9.17948 854.158012C9.17948 923.769568 65.248004 980.289737 134.081773 980.289737L927.938515 980.289737 952.914125 980.289737 952.914125 955.026579 952.914125 471.100561C952.914125 457.148105 941.732164 445.837402 927.938515 445.837402 914.144868 445.837402 902.962906 457.148105 902.962906 471.100561L902.962906 955.026579 927.938515 929.76342 134.081773 929.76342C92.797081 929.76342 59.130699 895.825847 59.130699 854.158012L59.130699 256.203386 34.155089 281.466543 598.93821 281.466543C612.731859 281.466543 623.91382 270.155842 623.91382 256.203386 623.91382 242.250928 612.731859 230.940227 598.93821 230.940227L34.155089 230.940227Z"  ></path>' +
    '' +
    '<path d="M437.016339 593.503789 431.876019 600.104892 431.668623 608.505214 427.984924 757.709741 427.077935 794.446421 461.312335 782.146455 605.005395 730.519447 611.980762 728.013291 616.479561 722.067243 1003.181673 210.964228 1018.529978 190.678421 998.306108 175.379305 869.49174 77.932781 849.985487 63.176536 834.913446 82.53177 437.016339 593.503789ZM839.575373 118.395018 968.389739 215.841542 963.514174 180.256619 576.81206 691.359633 588.286225 682.907428 444.593165 734.534436 477.920574 758.971151 481.604275 609.766622 476.256559 624.768047 874.153664 113.79603 839.575373 118.395018Z"  ></path>' +
    '' +
    '<path d="M891.217762 310.505713 920.474916 269.553252 808.309143 187.564266 779.051989 228.516725 891.217762 310.505713Z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-email" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M972.8 934.274509 998.4 908.54902 127.868001 908.54902C85.502225 908.54902 51.2 874.019706 51.2 831.263017L51.2 111.058823 25.6 136.784314 896.131998 136.784314C938.452011 136.784314 972.8 171.324278 972.8 213.860934L972.8 278.566694C972.8 292.77449 984.26151 304.292183 998.4 304.292183 1012.53849 304.292183 1024 292.77449 1024 278.566694L1024 213.860934C1024 142.916556 966.736828 85.333333 896.131998 85.333333L25.6 85.333333 0 85.333333 0 111.058823 0 831.263017C0 902.415639 57.205646 960 127.868001 960L998.4 960 1024 960 1024 934.274509 1024 457.69849C1024 443.490694 1012.53849 431.973001 998.4 431.973001 984.26151 431.973001 972.8 443.490694 972.8 457.69849L972.8 934.274509Z"  ></path>' +
    '' +
    '<path d="M512.651558 567.164817C520.64791 572.874498 531.187889 573.490406 539.788919 568.750601L1002.624789 313.693694C1015.021598 306.862133 1019.560139 291.225196 1012.761901 278.767619 1005.963665 266.310041 990.403006 261.749254 978.006197 268.580816L515.170327 523.637722 542.307689 525.223505 194.028065 276.539467C182.502788 268.310009 166.520953 271.027598 158.331639 282.609372 150.142325 294.191146 152.846657 310.251322 164.371935 318.480781L512.651558 567.164817Z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-help" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M1024 512C1024 229.230208 794.769792 0 512 0 229.230208 0 0 229.230208 0 512 0 794.769792 229.230208 1024 512 1024 629.410831 1024 740.826187 984.331046 830.768465 912.686662 841.557579 904.092491 843.33693 888.379234 834.742758 877.590121 826.148587 866.801009 810.43533 865.021658 799.646219 873.615827 718.470035 938.277495 618.001779 974.048781 512 974.048781 256.817504 974.048781 49.951219 767.182496 49.951219 512 49.951219 256.817504 256.817504 49.951219 512 49.951219 767.182496 49.951219 974.048781 256.817504 974.048781 512 974.048781 599.492834 949.714859 683.336764 904.470807 755.960693 897.177109 767.668243 900.755245 783.071797 912.462793 790.365493 924.170342 797.659191 939.573897 794.081058 946.867595 782.373508 997.013826 701.880796 1024 608.898379 1024 512Z"  ></path>' +
    '' +
    '<path d="M533.078812 691.418556C551.918022 691.418556 567.190219 706.673952 567.190219 725.511386L567.190219 734.541728C567.190219 753.370677 552.049365 768.634558 533.078812 768.634558L533.078812 768.634558C514.239601 768.634558 498.967405 753.379162 498.967405 734.541728L498.967405 725.511386C498.967405 706.682436 514.108258 691.418556 533.078812 691.418556L533.078812 691.418556ZM374.634146 418.654985C374.634146 418.654985 377.308518 442.210609 403.631972 442.210609 429.955424 442.210609 431.511799 418.654985 431.511799 418.654985 429.767552 342.380653 465.107535 306.162338 537.45591 309.760186 585.612324 315.19693 610.562654 342.380653 612.231066 391.391309 608.894242 413.21824 590.617557 441.441342 558.083539 475.90071 515.008196 519.47462 493.470524 558.49126 493.470524 592.950626L493.470524 628.289468C493.470524 628.289468 496.775846 649.365867 520.582206 649.365867 544.388565 649.365867 547.693888 628.289468 547.693888 628.289468L547.693888 603.744164C547.693888 574.961397 568.321517 540.342125 609.652612 500.28611 652.879629 460.469948 674.341463 424.091729 674.341463 391.391309 670.777131 300.725594 623.530758 253.473886 532.223166 249.796087 427.189099 248.037141 374.634146 304.323439 374.634146 418.654985Z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-more" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M642.174253 504.59418C650.164439 511.835287 650.070886 522.174253 641.84009 529.376198L332.618569 799.94503C323.751654 807.703582 322.853148 821.181184 330.611697 830.048098 338.370249 838.915012 351.847851 839.813519 360.714765 832.05497L669.936288 561.486138C697.36486 537.486138 697.727953 497.358861 670.825747 472.978737L360.992414 192.192278C352.26205 184.280386 338.770837 184.943889 330.858944 193.674252 322.947053 202.404616 323.610556 215.895829 332.340919 223.807723L642.174253 504.59418Z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-selected" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M464.247574 677.487844C474.214622 686.649009 489.665824 686.201589 499.086059 676.479029L798.905035 367.037898C808.503379 357.131511 808.253662 341.319801 798.347275 331.721456 788.44089 322.12311 772.62918 322.372828 763.030833 332.279215L463.211858 641.720346 498.050342 640.711531 316.608839 473.940462C306.453341 464.606085 290.653676 465.271736 281.319299 475.427234 271.984922 485.582733 272.650573 501.382398 282.806071 510.716775L464.247574 677.487844Z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-add" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M853.333333 533.333333C865.115407 533.333333 874.666667 523.782074 874.666667 512 874.666667 500.217926 865.115407 490.666667 853.333333 490.666667L170.666667 490.666667C158.884592 490.666667 149.333333 500.217926 149.333333 512 149.333333 523.782074 158.884592 533.333333 170.666667 533.333333L853.333333 533.333333Z"  ></path>' +
    '' +
    '<path d="M490.666667 853.333333C490.666667 865.115407 500.217926 874.666667 512 874.666667 523.782074 874.666667 533.333333 865.115407 533.333333 853.333333L533.333333 170.666667C533.333333 158.884592 523.782074 149.333333 512 149.333333 500.217926 149.333333 490.666667 158.884592 490.666667 170.666667L490.666667 853.333333Z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-favorites" viewBox="0 0 1143 1024">' +
    '' +
    '<path d="M840.870698 8.239628c-80.634047 0-153.790512 31.672558-207.967256 83.134512a24.957023 24.957023 0 0 0-9.287442 19.33693 25.099907 25.099907 0 0 0 42.984186 17.598511l0.047628 0.023814c45.246512-43.341395 106.61507-69.989209 174.222884-69.989209 139.240186 0 252.094512 112.87814 252.094511 252.094512 0 67.631628-26.671628 128.952558-69.989209 174.246697l-451.322047 451.750698-451.560186-451.750698a251.165767 251.165767 0 0 1-70.013023-174.246697C50.080744 171.222326 162.958884 58.344186 302.19907 58.344186c66.917209 0 127.690419 26.171535 172.841674 68.72707l150.599442 150.456558a24.909395 24.909395 0 0 0 35.244651-35.244651l-149.14679-149.265861 0.119069-0.095255A301.127442 301.127442 0 0 0 302.19907 8.239628C135.263256 8.239628 0 143.550512 0 310.438698c0 81.443721 32.267907 155.314605 84.658605 209.658046l486.995348 486.828651 487.042977-487.138232A301.103628 301.103628 0 0 0 1143.069767 310.462512C1143.069767 143.526698 1007.782698 8.239628 840.870698 8.239628"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '</svg>'
  var script = function() {
    var scripts = document.getElementsByTagName('script')
    return scripts[scripts.length - 1]
  }()
  var shouldInjectCss = script.getAttribute("data-injectcss")

  /**
   * document ready
   */
  var ready = function(fn) {
    if (document.addEventListener) {
      if (~["complete", "loaded", "interactive"].indexOf(document.readyState)) {
        setTimeout(fn, 0)
      } else {
        var loadFn = function() {
          document.removeEventListener("DOMContentLoaded", loadFn, false)
          fn()
        }
        document.addEventListener("DOMContentLoaded", loadFn, false)
      }
    } else if (document.attachEvent) {
      IEContentLoaded(window, fn)
    }

    function IEContentLoaded(w, fn) {
      var d = w.document,
        done = false,
        // only fire once
        init = function() {
          if (!done) {
            done = true
            fn()
          }
        }
        // polling for no errors
      var polling = function() {
        try {
          // throws errors until after ondocumentready
          d.documentElement.doScroll('left')
        } catch (e) {
          setTimeout(polling, 50)
          return
        }
        // no errors, fire

        init()
      };

      polling()
        // trying to always fire before onload
      d.onreadystatechange = function() {
        if (d.readyState == 'complete') {
          d.onreadystatechange = null
          init()
        }
      }
    }
  }

  /**
   * Insert el before target
   *
   * @param {Element} el
   * @param {Element} target
   */

  var before = function(el, target) {
    target.parentNode.insertBefore(el, target)
  }

  /**
   * Prepend el to target
   *
   * @param {Element} el
   * @param {Element} target
   */

  var prepend = function(el, target) {
    if (target.firstChild) {
      before(el, target.firstChild)
    } else {
      target.appendChild(el)
    }
  }

  function appendSvg() {
    var div, svg

    div = document.createElement('div')
    div.innerHTML = svgSprite
    svgSprite = null
    svg = div.getElementsByTagName('svg')[0]
    if (svg) {
      svg.setAttribute('aria-hidden', 'true')
      svg.style.position = 'absolute'
      svg.style.width = 0
      svg.style.height = 0
      svg.style.overflow = 'hidden'
      prepend(svg, document.body)
    }
  }

  if (shouldInjectCss && !window.__iconfont__svg__cssinject__) {
    window.__iconfont__svg__cssinject__ = true
    try {
      document.write("<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>");
    } catch (e) {
      console && console.log(e)
    }
  }

  ready(appendSvg)


})(window)