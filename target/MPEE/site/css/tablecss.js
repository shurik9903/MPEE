export const TableCSS = '<style>'+
                                            '.table {'+
                                             'border-collapse: collapse;'+
                                             'border-spacing: 10;'+
                                             'width: 100%;'+
                                             '}'+


                                         '.table th, .table td {'+
                                             'border: 1px solid #888;'+
                                             'padding: 10px;'+
                                             'text-align: center;'+
                                             'vertical-align: middle;'+
                                             'position: relative;'+
                                             'cursor: pointer;'+
                                         '}'+


                                         '.table .hover td:after {'+
                                             'content: "";'+
                                             'position: absolute;'+
                                             'top: 0px;'+
                                             'right: 0px;'+
                                             'bottom: 0px;'+
                                             'left: 0px;'+
                                             'width: 105%;'+
                                             'border-top: 3px solid #ffe5c5;'+
                                             'border-bottom: 3px solid #ffe5c5;'+
                                         '}'+

                                         '.table .hover td:first-child:after {'+
                                             'border-left: 3px solid #ffe5c5;'+
                                         '}'+

                                         '.table .hover td:last-child:after {'+
                                             'border-right: 3px solid #ffe5c5;'+
                                             'width: auto;'+
                                         '}'+

                                         '.table .active td:after {'+
                                             'content: "";'+
                                             'position: absolute;'+
                                             'top: 0px;'+
                                             'right: 0px;'+
                                             'bottom: 0px;'+
                                             'left: 0px;'+
                                             'width: 105%;'+
                                             'border-top: 3px solid orange;'+
                                             'border-bottom: 3px solid orange;'+
                                         '}'+

                                         '.table .active td:first-child:after {'+
                                             'border-left: 3px solid orange;'+
                                         '}'+

                                         '.table .active td:last-child:after {'+
                                             'border-right: 3px solid orange;'+
                                             'width: auto;'+
                                         '}'+

                                       '</style>';