package com.sistema.ayudantes.sistayudantes.Email;

import jdk.jfr.Description;

public class ConfirmationEmail {

    @Description("retorna el html con el formato del mail como String. nombre refiere al ayudante y materia a la que se lo esta invitando")

    public static String buildEmail(String nombre, String materia, String id_ayudante, String id_materia){
        return  "<html lang=\"en\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
                "<head>\n" +
                "    <title></title>\n" +
                "    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                "    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/>\n" +
                "    <!--[if mso]>\n" +
                "    <xml>\n" +
                "        <o:OfficeDocumentSettings>\n" +
                "            <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "            <o:AllowPNG/>\n" +
                "        </o:OfficeDocumentSettings>\n" +
                "    </xml><![endif]-->\n" +
                "    <style>\n" +
                "        * {\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "\n" +
                "        a[x-apple-data-detectors] {\n" +
                "            color: inherit !important;\n" +
                "            text-decoration: inherit !important;\n" +
                "        }\n" +
                "\n" +
                "        #MessageViewBody a {\n" +
                "            color: inherit;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "\n" +
                "        p {\n" +
                "            line-height: inherit\n" +
                "        }\n" +
                "\n" +
                "        .desktop_hide,\n" +
                "        .desktop_hide table {\n" +
                "            mso-hide: all;\n" +
                "            display: none;\n" +
                "            max-height: 0px;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "\n" +
                "        @media (max-width: 520px) {\n" +
                "            .desktop_hide table.icons-inner {\n" +
                "                display: inline-block !important;\n" +
                "            }\n" +
                "\n" +
                "            .icons-inner {\n" +
                "                text-align: center;\n" +
                "            }\n" +
                "\n" +
                "            .icons-inner td {\n" +
                "                margin: 0 auto;\n" +
                "            }\n" +
                "\n" +
                "            .image_block img.big,\n" +
                "            .row-content {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "\n" +
                "            .mobile_hide {\n" +
                "                display: none;\n" +
                "            }\n" +
                "\n" +
                "            .stack .column {\n" +
                "                width: 100%;\n" +
                "                display: block;\n" +
                "            }\n" +
                "\n" +
                "            .mobile_hide {\n" +
                "                min-height: 0;\n" +
                "                max-height: 0;\n" +
                "                max-width: 0;\n" +
                "                overflow: hidden;\n" +
                "                font-size: 0px;\n" +
                "            }\n" +
                "\n" +
                "            .desktop_hide,\n" +
                "            .desktop_hide table {\n" +
                "                display: table !important;\n" +
                "                max-height: none !important;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body style=\"background-color: #FFFFFF; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\"\n" +
                "       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 500px;\"\n" +
                "                               width=\"500\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                "                                                <div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img\n" +
                "                                                        class=\"big\" src=\"https://www.unicen.edu.ar/sites/default/files/imagenes/actualidad/2011-01/UNICEN.jpg\"\n" +
                "                                                        style=\"display: block; height: auto; border: 0; width: 434px; max-width: 100%;\"\n" +
                "                                                        width=\"434\"/></div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 500px;\"\n" +
                "                               width=\"500\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"text-align:center;width:100%;\">\n" +
                "                                                <h1 style=\"margin: 0; color: #555555; direction: ltr; font-family: Arial, Helvetica Neue, Helvetica, sans-serif; font-size: 30px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n" +
                "                                                    <span class=\"tinyMce-placeholder\">Hola "+ nombre +"</span></h1>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-4\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 500px;\"\n" +
                "                               width=\"500\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-2\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"padding-bottom:10px;padding-left:10px;padding-right:10px;padding-top:20px;\">\n" +
                "                                                <div style=\"color:#000000;direction:ltr;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;\">\n" +
                "                                                    <p style=\"margin: 0;\">Nos comunicamos para informarle que ha sido\n" +
                "                                                        seleccionado como ayudante de catedra para la materia\n" +
                "                                                        "+ materia+", por favor, haga click en el link a continuación para\n" +
                "                                                            aceptar la ayudantía\n" +
                "                                                    </p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-5\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 500px;\"\n" +
                "                               width=\"500\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"button_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div align=\"center\" class=\"alignment\">\n" +
                "                                                    <!--[if mso]>\n" +
                "                                                    <v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
                "                                                                 xmlns:w=\"urn:schemas-microsoft-com:office:word\"\n" +
                "                                                                 href=\"http://localhost:4567/aceptar-materia?id_persona="+id_ayudante+"&id_materia="+id_materia+"\"\n" +
                "                                                                 style=\"height:58px;width:235px;v-text-anchor:middle;\"\n" +
                "                                                                 arcsize=\"7%\" stroke=\"false\" fillcolor=\"#3AAEE0\">\n" +
                "                                                        <w:anchorlock/>\n" +
                "                                                        <v:textbox inset=\"0px,0px,0px,0px\">\n" +
                "                                                            <center style=\"color:#ffffff; font-family:Arial, sans-serif; font-size:24px\">\n" +
                "                                                    <![endif]--><a href=\"http://localhost:4567/aceptar-materia?id_persona="+id_ayudante+"&id_materia="+id_materia+"\" !--Aca va de verdad el link--\n" +
                "                                                                   style=\"text-decoration:none;display:inline-block;color:#ffffff;background-color:#3AAEE0;border-radius:4px;width:auto;border-top:0px solid transparent;font-weight:400;border-right:0px solid transparent;border-bottom:0px solid transparent;border-left:0px solid transparent;padding-top:5px;padding-bottom:5px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\"\n" +
                "                                                                   target=\"_blank\"><span\n" +
                "                                                        style=\"padding-left:20px;padding-right:20px;font-size:24px;display:inline-block;letter-spacing:normal;\"><span\n" +
                "                                                        dir=\"ltr\" style=\"word-break: break-word; line-height: 48px;\">Aceptar Ayudantía</span></span></a>\n" +
                "                                                    <!--[if mso]></center></v:textbox></v:roundrect><![endif]-->\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-6\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 500px;\"\n" +
                "                               width=\"500\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"paragraph_block block-1\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div style=\"color:#000000;direction:ltr;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;\">\n" +
                "                                                    <p style=\"margin: 0;\">Si por alguna razón usted no desea participar\n" +
                "                                                        como ayudante de "+ materia +", por favor haga click en el\n" +
                "                                                        siguiente enlace para rechazar la invitación</p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-7\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 500px;\"\n" +
                "                               width=\"500\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"button_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div align=\"center\" class=\"alignment\">\n" +
                "                                                    <!--[if mso]>\n" +
                "                                                    <v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
                "                                                                 xmlns:w=\"urn:schemas-microsoft-com:office:word\"\n" +
                "                                                                 href=\"http://localhost:4567/rechazar-materia?id_persona="+id_ayudante+"&id_materia="+id_materia+"\"\n" +
                "                                                                 style=\"height:58px;width:255px;v-text-anchor:middle;\"\n" +
                "                                                                 arcsize=\"7%\" stroke=\"false\" fillcolor=\"#3AAEE0\">\n" +
                "                                                        <w:anchorlock/>\n" +
                "                                                        <v:textbox inset=\"0px,0px,0px,0px\">\n" +
                "                                                            <center style=\"color:#ffffff; font-family:Arial, sans-serif; font-size:24px\">\n" +
                "                                                    <![endif]--><a href=\"http://localhost:4567/rechazar-materia?id_persona="+id_ayudante+"&id_materia="+id_materia+"\" !--Aca va de verdad el link--\n" +
                "                                                                   style=\"text-decoration:none;display:inline-block;color:#ffffff;background-color:#3AAEE0;border-radius:4px;width:auto;border-top:0px solid transparent;font-weight:400;border-right:0px solid transparent;border-bottom:0px solid transparent;border-left:0px solid transparent;padding-top:5px;padding-bottom:5px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\"\n" +
                "                                                                   target=\"_blank\"><span\n" +
                "                                                        style=\"padding-left:20px;padding-right:20px;font-size:24px;display:inline-block;letter-spacing:normal;\"><span\n" +
                "                                                        dir=\"ltr\" style=\"word-break: break-word; line-height: 48px;\">Rechazar Ayudantía</span></span></a>\n" +
                "                                                    <!--[if mso]></center></v:textbox></v:roundrect><![endif]-->\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-8\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 500px;\"\n" +
                "                               width=\"500\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"icons_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"vertical-align: middle; color: #9d9d9d; font-family: inherit; font-size: 15px; padding-bottom: 5px; padding-top: 5px; text-align: center;\">\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"\n" +
                "                                                       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                                       width=\"100%\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td class=\"alignment\"\n" +
                "                                                            style=\"vertical-align: middle; text-align: center;\">\n" +
                "                                                            <!--[if vml]>\n" +
                "                                                            <table align=\"left\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                   role=\"presentation\"\n" +
                "                                                                   style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\">\n" +
                "                                                            <![endif]-->\n" +
                "                                                            <!--[if !vml]><!-->\n" +
                "                                                        </td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table><!-- End -->\n" +
                "</body>\n" +
                "</html>";
    }
}
